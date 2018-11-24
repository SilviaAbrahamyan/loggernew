package com.egs.training.logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by user on 12/26/2017.
 */
public class FileHandler implements Handler {
    String fileName;

    FileHandler(String fileName){
        this.fileName=fileName;
    }

    public String getDate(LogRecord logRecord){
        Date date=new Date(logRecord.getTime());
        SimpleDateFormat formatYMD=new SimpleDateFormat("yyyy-MM-dd");
        return formatYMD.format(date);
    }


    @Override
    public void append(LogRecord logRecord){
        File file=new File("src/com/egs/training/history/"+fileName+"_"+getDate(logRecord));
        try {
            FileWriter fw= new FileWriter(file,true);
            BufferedWriter bw= new BufferedWriter(fw);
            PrintWriter pw=new PrintWriter(bw);
            pw.println();
            pw.println(logRecord.toString());
            pw.close();

        } catch (IOException e) {

        }
    }
    private boolean old(File file){
        double diff = System.currentTimeMillis() - file.lastModified();
        diff = diff / 1000 / 60 / 60 / 24;
        return diff>=5;
    }

    public void deleteOldFiles(){
        File file=new File("src/com/egs/training/history");
        for (File f : file.listFiles()){
            if (old(f)){
                f.delete();
            }
        }
    }
}
