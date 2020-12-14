package ir.ssatari.envers.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RevisionType {
    @JsonProperty("add")
    ADD,

    @JsonProperty("mod")
    MOD,

    @JsonProperty("del")
    DEL
}
