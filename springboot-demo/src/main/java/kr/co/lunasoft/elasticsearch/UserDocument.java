package kr.co.lunasoft.elasticsearch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Document(indexName = "user-document-log", type = "_doc")
public class UserDocument {

    // ID
    @Id
    private String id;

    // 이름
    @Field(type = FieldType.Text)
    private String name;

    // 나이
    @Field(type = FieldType.Integer)
    private int age;

    // 현재일시
    @Field(type = FieldType.Date)
    private String logDate;

    // 로깅 텍스트
    @Field(type = FieldType.Text, index = false)
    private String logText;

}
