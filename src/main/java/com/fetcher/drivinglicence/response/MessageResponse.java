package com.fetcher.drivinglicence.response;

import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@Builder
public class MessageResponse {
    private String message;
    private String status;
}
