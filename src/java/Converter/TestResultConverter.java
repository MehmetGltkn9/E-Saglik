package Converter;

import Entity.Admin;
import Entity.TestResult;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestResultConverter extends BaseConverter<TestResult> {

    public TestResultConverter() {
        super();
    }

    @Override
    public String ConvertToString(TestResult testResult) {
        return "TestResult{"
                + "id=" + testResult.getId()
                + ", name='" + testResult.getName() + '\''
                + ", date=" + testResult.getDate()
                + ", testType='" + testResult.getTestType() + '\''
                + ", testName='" + testResult.getTestName() + '\''
                + ", testNormalValue='" + testResult.getTestNormalValue() + '\''
                + ", testValue='" + testResult.getTestValue() + '\''
                + '}';
    }

    @Override
    public TestResult ConvertToEntity(String string) throws IllegalAccessException, InstantiationException {
        TestResult testResult = null;

        String pattern = "id=(\\d+)";
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(string);

        if (matcher.find()) {
            String idString = matcher.group(1); // Grup 1, parantez içindeki ifadeyi temsil eder
            int id = Integer.parseInt(idString);
            String[] parts = string.split(", ");

            if (parts.length >= 6) { // En az 6 özelliğin olması gerekiyor (id, name, date, testType, testName, testNormalValue)
                Date date = null;
                String testType = null;
                String testName = null;
                String testNormalValue = null;
                String testValue = null;

                for (String part : parts) {
                    String[] keyValue = part.split("=");
                    if (keyValue.length == 2) {
                        String key = keyValue[0];
                        String value = keyValue[1];
                        switch (key) {
                            case "name":
                                testResult = new TestResult();
                                testResult.setId(id);
                                testResult.setName(value);
                                break;
                            case "date":
                                try {
                                    date = new SimpleDateFormat("yyyy-MM-dd").parse(value);
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                break;
                            case "testType":
                                testType = value;
                                break;
                            case "testName":
                                testName = value;
                                break;
                            case "testNormalValue":
                                testNormalValue = value;
                                break;
                            case "testValue":
                                testValue = value;
                                break;
                            default:
                                // Handle unknown key or ignore
                                break;
                        }
                    }
                }

                if (testResult != null) {
                    testResult.setDate(date);
                    testResult.setTestType(testType);
                    testResult.setTestName(testName);
                    testResult.setTestNormalValue(testNormalValue);
                    testResult.setTestValue(testValue);
                }
            } else {
                System.out.println("Insufficient properties to create TestResult object.");
            }
        } else {
            System.out.println("ID not found.");
        }

        return testResult;
    }

}
