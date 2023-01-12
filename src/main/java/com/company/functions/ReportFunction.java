package com.company.functions;

import com.company.models.CommonRequest;
import com.company.models.CommonResponse;
import com.company.models.Country;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Logger;

@Component
public class ReportFunction implements Function<CommonRequest, CommonResponse> {
    private static final Logger LOG = Logger.getLogger(String.valueOf(ReportFunction.class));

    @Override
    public CommonResponse apply(CommonRequest request) {
        System.setProperty("user.dir", "/tmp/");
        JasperReport jasperReport = null;
        try {
            jasperReport = getJasperReport();
        } catch (FileNotFoundException | JRException e) {
            throw new RuntimeException(e);
        }
        Map<String, Object> parameters = getParameters();

        JRDataSource dataSource = getDataSource();

        JasperPrint jasperPrint = null;
        try {
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        } catch (JRException e) {
            throw new RuntimeException(e);
        }
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, "/tmp/report.pdf");
        } catch (JRException e) {
            throw new RuntimeException(e);
        }

        CommonResponse response = new CommonResponse();
        response.setResult("Success");

        LOG.info("[INFO] " + response.getResult());

        return response;
    }


    private static JasperReport getJasperReport() throws FileNotFoundException, JRException {
        File template = ResourceUtils.getFile("classpath:report.jrxml");
        return JasperCompileManager.compileReport(template.getAbsolutePath());
    }

    private static Map<String, Object> getParameters() {
        return new HashMap<>();
    }

    private static JRDataSource getDataSource() {
        List<Country> countries = new LinkedList<>();
        countries.add(new Country("VN", "Vietnam", "https://vn-live-01.slatic.net/p/20ec8bbada53eba3633bf0f358226287.jpg"));

        return new JRBeanCollectionDataSource(countries);
    }
}
