package de.woomazons.controller;


import de.woomazons.Constants;
import de.woomazons.model.Input;
import de.woomazons.model.Result;
import de.woomazons.service.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {

    @Autowired
    private RepositoryService repositoryService;

    @RequestMapping("/")
    public String getLabels() {
        return "start";
    }

    @RequestMapping(value = "/calc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Result getResult(@RequestBody Input input) {
        return calculate(input.getIncome(), input.getSize(), input.isMonthly());
    }

    private Result calculate(int income, int size, boolean monthly) {
        if (!monthly) {
            income = income * 12;
        }

        Result result = Result.builder()
                .bAct((calcPercentage(income, Constants.B_ACT)) + (size * Constants.FACT_B))
                .bPro((calcPercentage(income, Constants.B_PRO)) + (size * Constants.FACT_B))
                .dAct((calcPercentage(income, Constants.D_ACT)) - (size * Constants.FACT))
                .dPro((calcPercentage(income, Constants.D_PRO)) - (size * Constants.FACT))
                .lAct((calcPercentage(income, Constants.L_ACT)) - (size * Constants.FACT))
                .lPro((calcPercentage(income, Constants.L_PRO)) - (size * Constants.FACT))
                .pAct((calcPercentage(income, Constants.P_ACT)) - (size * Constants.FACT))
                .pPro((calcPercentage(income, Constants.P_PRO)) - (size * Constants.FACT))
                .build();

        result.setBDiff(result.getBPro() - result.getBAct());
        result.setDDiff(result.getDPro() - result.getDAct());
        result.setLDiff(result.getLPro() - result.getLAct());
        result.setPDiff(result.getPPro() - result.getPAct());

        return result;
    }

    private int calcPercentage(int income, int percentage) {
        int i = (income / 100) * percentage;
        return i;
    }

}

