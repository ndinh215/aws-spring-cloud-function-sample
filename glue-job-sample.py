import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job

import sys
from awsglue.transforms import *
from awsglue.utils import getResolvedOptions
from pyspark.context import SparkContext
from awsglue.context import GlueContext
from awsglue.job import Job
import boto3, json, decimal

import random
import string

sc = SparkContext.getOrCreate()
glueContext = GlueContext(sc)
spark = glueContext.spark_session
job = Job(glueContext)
logger = glueContext.get_logger()

testTable = glueContext.create_dynamic_frame.from_options("dynamodb",
    connection_options={
        "dynamodb.input.tableName": "test-table"
    }
)

print("Count:", testTable.count())
testTable.printSchema()

sqs = boto3.client('sqs', region_name="us-west-2")
queueUrl = 'https://sqs.us-west-2.amazonaws.com/743949180496/testQueue.fifo'  

testTable.toDF().show()
rows = testTable.toDF().collect()

def get_random_string(length):
    letters = string.ascii_lowercase
    result = ''.join(random.choice(letters) for i in range(length))
    
    return result

for item in rows:
    memberName = rows[0].asDict()['memberName']
    response = sqs.send_message(
        QueueUrl=queueUrl,
        MessageAttributes={
            'member': {
                'DataType': 'String',
                'StringValue': memberName
            }
        },
        MessageGroupId='test-group',
        MessageDeduplicationId=get_random_string(8),
        MessageBody=('Example message')
    )
    
    print(response['MessageId'])

job.commit()
