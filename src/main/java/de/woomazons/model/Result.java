package de.woomazons.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Result {

    // pension actual, proposed, difference
    int pAct;
    int pPro;
    int pDiff;

    // dreams actual, proposed, difference
    int dAct;
    int dPro;
    int dDiff;

    // Lifestyle actual, proposed, difference
    int lAct;
    int lPro;
    int lDiff;

    // Basic actual, proposed, difference
    int bAct;
    int bPro;
    int bDiff;
}

