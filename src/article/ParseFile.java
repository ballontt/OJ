package article;

import java.io.*;

/**
 * Created by ballontt on 2017/11/13.
 */
public class ParseFile {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\elapsedTime-load.txt";
        String newFile = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\new-load.txt";

        String initCpu = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\init-cput.txt";
        String initMem = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\init-mem.txt";
        String execCpu = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\exec-cpu.txt";
        String execMem = "C:\\Users\\ballontt\\Desktop\\论文资料\\实验\\exec-mem.txt";

        FileWriter f1 = new FileWriter(initCpu);
        FileWriter f2 = new FileWriter(initMem);
        FileWriter f3 = new FileWriter(execCpu);
        FileWriter f4 = new FileWriter(execMem);
        BufferedWriter b1 = new BufferedWriter(f1);
        BufferedWriter b2 = new BufferedWriter(f2);
        BufferedWriter b3 = new BufferedWriter(f3);
        BufferedWriter b4 = new BufferedWriter(f4);

        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(newFile);
        BufferedWriter bw = new BufferedWriter(fw);

        String preLine = "";
        String currentLine;
        while((currentLine = br.readLine()) != null) {
            if(currentLine.contains("=") || currentLine.contains("*")) continue;
            if(currentLine.contains("seed")) {
                bw.write(currentLine, 0, currentLine.length());
                bw.newLine();
            } else if(currentLine.contains("init")) {
                String initLine = currentLine + " " + preLine;
                bw.write(initLine, 0, initLine.length());
                bw.newLine();
            } else if(currentLine.contains("exec")) {
                String execLine = currentLine + " " + preLine;
                bw.write(execLine, 0, execLine.length());
                bw.newLine();
            }
            if(currentLine.contains("Cpu")) {
                preLine = currentLine;
            }
        }

        FileReader f5 = new FileReader(newFile);
        BufferedReader r5 = new BufferedReader(f5);

        while((currentLine = r5.readLine()) != null) {
            if(!currentLine.contains("seed")) {
                String[] strs = currentLine.split(":");
                if(strs.length >= 4) {
                    String cpu = strs[2].split("\t")[0];
                    String mem = strs[3];
                    if(currentLine.contains("init")) {
                        b1.write(cpu);
                        b1.newLine();
                        b2.write(mem);
                        b2.newLine();
                    } else if(currentLine.contains("exec")) {
                        b3.write(cpu);
                        b3.newLine();
                        b4.write(mem);
                        b4.newLine();
                    }
                }
            }
        }
        b1.flush();
        b2.flush();
        b3.flush();
        b4.flush();
    }
}
