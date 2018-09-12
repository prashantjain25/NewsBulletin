package com.newsbulletin.util;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import com.newsbulletin.entity.Headline;
import com.newsbulletin.entity.Newspaper;
import com.newsbulletin.model.NewsRowBinder;

public class BulletinCSVReader {
    private static final String SAMPLE_CSV_FILE_PATH = "src/main/resources/META-INF/news_bulletin666200b.csv";

    public static List<NewsRowBinder> reader() throws IOException {
        try (
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            List<NewsRowBinder> list=new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                // Accessing Values by Column Index
                String headline = csvRecord.get(1);
                String headlineUrl = csvRecord.get(2);
                String newspaperOrg = csvRecord.get(3);
                String type = csvRecord.get(4);
                String domainUrl=csvRecord.get(5);
                long serialUid=Long.parseLong(csvRecord.get(6));

                Headline headlne=new Headline();
                headlne.setHeadlines(headline);
                headlne.setHeadlineUrl(headlineUrl);
                headlne.setIdentifier(serialUid);
                headlne.setType(type);
                
                
                Newspaper news=new Newspaper();
                
                news.setDomainUrl(domainUrl);
                news.setPublisher(newspaperOrg);
                headlne.setNewspaper(news);
                NewsRowBinder binder=new NewsRowBinder();
                binder.setHeadlines(headlne);
                binder.setNewspaper(news);
                list.add(binder);
            }
            return list;
        }
    }
}
