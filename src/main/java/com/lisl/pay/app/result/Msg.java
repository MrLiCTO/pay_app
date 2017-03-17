package com.lisl.pay.app.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by sang on 2017/1/10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Msg {
    private String title;
    private String content;
    private String extraInfo;
}
