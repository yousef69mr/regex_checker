import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String fileName = "D:\\JavaProjects\\RegexChecker\\src\\input.txt"; // Change this to your file path
        String outputFileName = "D:\\JavaProjects\\RegexChecker\\src\\output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

            String line, regex;
            int test_number;
            RegexChecker regexChecker;
            Matcher matcher;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                if (line.equals("end")) {
                    continue;
                }

                try {
                    test_number = Integer.parseInt(line);

                    switch (test_number) {
                        case 1:
                            writer.write("1\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}\\b";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid email \n");
                                } else {
                                    writer.write("Invalid email \n");
                                }
                            }
                            writer.write("x\n");
                            break;

                        case 2:
                            writer.write("2\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "(\\d{3}|\\(\\d{3}\\))[-]?\\s*\\d{3}[\\s\\.\\-]?\\d{4}";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid phone number \n");
                                } else {
                                    writer.write("Invalid phone number \n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 3:
                            writer.write("3\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "\\b(\\d{4}/\\d{2}/\\d{2}|\\d{4}-\\d{2}-\\d{2}|\\d{2}/\\d{2}/\\d{4}|\\d{1}/\\d{2}/\\d{4}|\\d{2}/\\d/\\d{4}|\\d{2}-\\d{2}-\\d{4}|\\d{1}-\\d{2}-\\d{4}|\\d{2}-\\d{1}-\\d{4})\\b";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid date \n");
                                } else {
                                    writer.write("Invalid date \n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 4:
                            writer.write("4\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid IP address \n");
                                } else {
                                    writer.write("Invalid IP address \n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 5:
                            writer.write("5\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "\\b[a-zA-Z_][a-zA-Z0-9_]*\\b";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid c++ variable \n");
                                } else {
                                    writer.write("Invalid c++ variable \n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 6:
                            writer.write("6\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "(?i)(?!.*bbb).*";
                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);

                                if (matcher.matches()) {
                                    writer.write("valid string \n");
                                } else {
                                    writer.write("Invalid string, has 3 consecutive b’s \n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 7:
                            // not working
                            writer.write("7\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "(b+a+)(?:^[a-z]{2})|(a+b+)(?:[a-z]{2})";
                                regexChecker = new RegexChecker(regex);

                                matcher = regexChecker.check(line);
                                writer.write("*" + line + "*\n");
                                int count = 0;
                                while (matcher.find()) {
                                    count++;
                                }
                                if (count > 0) {
                                    writer.write("number of matched substrings: " + count + "\n");
                                } else {
                                    writer.write("No substring matches\n");
                                }
                                matcher.reset();
                                while (matcher.find()) {
                                    System.out.println(matcher.group());
                                    writer.write("matched substring: " + matcher.group() + "\n");
                                    writer.write("start index: " + matcher.start() + ", end index: " + matcher.end() + "\n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 8:
                            writer.write("8\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "\\b\\w{3}\\b";
                                regexChecker = new RegexChecker(regex);

                                matcher = regexChecker.check(line);
                                writer.write("*" + line + "*\n");
                                int count = 0;
                                while (matcher.find()) {
                                    count++;
                                }
                                if (count > 0) {
                                    writer.write("number of matched words: " + count + "\n");
                                } else {
                                    writer.write("No word matches\n");
                                }
                                matcher.reset();

                                while (matcher.find()) {
                                    writer.write("matched word: " + matcher.group() + "\n");
                                    writer.write("start index: " + matcher.start() + ", end index: " + matcher.end() + "\n");
                                }
                            }
                            writer.write("x\n");
                            break;
                        case 9:
                            writer.write("9\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "\\b(?:https?|ftp)://[^\\s/$.?#].[^\\s]*\\b[\\/]?";
                                regexChecker = new RegexChecker(regex);

                                writer.write("*" + line + "*\n");

                                // check if file exists
                                File file = new File(line);
                                if (!file.exists()) {
                                    writer.write("File not found: " + line + "\n");
                                    continue;
                                }
                                BufferedReader fileReader = new BufferedReader(new FileReader(file));

                                int lineNumber = 0;
                                int totalCount = 0;

                                // calculate total urls in a file before printing line urls
                                ArrayList<String> results = new ArrayList<>();

                                while ((line = fileReader.readLine()) != null) {
                                    lineNumber++;
                                    //System.out.println(line);
                                    matcher = regexChecker.check(line);

                                    while (matcher.find()) {
                                        totalCount++;
                                        results.add("URL: " + matcher.group() + "\nLine: " + lineNumber + "\nstart index: " + matcher.start() + ", end index: " + matcher.end() + "\n");
                                    }
                                }

                                writer.write("Number of URLs: " + totalCount + "\n");
                                for (String result : results) {
                                    writer.write(result);
                                }

                                fileReader.close();
                            }
                            writer.write("x\n");
                            break;
                        case 10:

                            writer.write("10\n");
                            while (!(line = reader.readLine()).equals("end")) {
                                regex = "[([-+]?\\d+\\.?\\d*[a-zA-Z]*)( ?[-+*/] ?[-+]?\\d*\\.?\\d*[a-zA-Z]*)*]+[=][([-+]?\\d+\\.?\\d*[a-zA-Z]*)( ?[-+*/] ?[-+]?\\d*\\.?\\d*[a-zA-Z]*)*]+";

                                regexChecker = new RegexChecker(regex);
                                matcher = regexChecker.check(line);
                                if (matcher.matches()) {
                                    writer.write("valid mathematical expression \n");
                                } else {
                                    writer.write("Invalid mathematical expression \n");
                                }

                            }
                            writer.write("x\n");
                            break;
                        default:
                            break;

                    }
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }

            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}