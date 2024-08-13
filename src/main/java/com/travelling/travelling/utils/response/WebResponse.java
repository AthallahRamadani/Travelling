package com.travelling.travelling.utils.response;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WebResponse<T> {
    private String message;
    private String status;
    private T data;
}
