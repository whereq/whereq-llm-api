package com.whereq.llm.openai.vo.moderation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.whereq.llm.gpt.vo.BaseVO;

/**
 * An object containing the flags for each moderation category
 *
 * https://platform.openai.com/docs/api-reference/moderations/create
 */
public class ModerationCategories extends BaseVO {

    public boolean hate;

    @JsonProperty("hate/threatening")
    public boolean hateThreatening;

    @JsonProperty("self-harm")
    public boolean selfHarm;

    public boolean sexual;

    @JsonProperty("sexual/minors")
    public boolean sexualMinors;

    public boolean violence;

    @JsonProperty("violence/graphic")
    public boolean violenceGraphic;

    public boolean isHate() {
        return hate;
    }

    public void setHate(boolean hate) {
        this.hate = hate;
    }

    public boolean isHateThreatening() {
        return hateThreatening;
    }

    public void setHateThreatening(boolean hateThreatening) {
        this.hateThreatening = hateThreatening;
    }

    public boolean isSelfHarm() {
        return selfHarm;
    }

    public void setSelfHarm(boolean selfHarm) {
        this.selfHarm = selfHarm;
    }

    public boolean isSexual() {
        return sexual;
    }

    public void setSexual(boolean sexual) {
        this.sexual = sexual;
    }

    public boolean isSexualMinors() {
        return sexualMinors;
    }

    public void setSexualMinors(boolean sexualMinors) {
        this.sexualMinors = sexualMinors;
    }

    public boolean isViolence() {
        return violence;
    }

    public void setViolence(boolean violence) {
        this.violence = violence;
    }

    public boolean isViolenceGraphic() {
        return violenceGraphic;
    }

    public void setViolenceGraphic(boolean violenceGraphic) {
        this.violenceGraphic = violenceGraphic;
    }

    @Override
    public String toString() {
        return (
            "ModerationCategories{" +
            "hate=" +
            hate +
            ", hateThreatening=" +
            hateThreatening +
            ", selfHarm=" +
            selfHarm +
            ", sexual=" +
            sexual +
            ", sexualMinors=" +
            sexualMinors +
            ", violence=" +
            violence +
            ", violenceGraphic=" +
            violenceGraphic +
            '}'
        );
    }
}
