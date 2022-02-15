package com.kinali.complaintsnet.core.business;

import com.kinali.complaintsnet.core.utilities.Result;

import java.util.ArrayList;
import java.util.List;
// run diyer bir fonksiyonu
// result List
// parametre olarak resultlar oluşan bir yapı alıyor
public class BusinessRules {
    public static Result[]run(Result... logics){
        List<Result> results = new ArrayList<Result>();
        for(Result logic:logics){
            if (!logic.isSuccess()){
                // eğer hatalar varsa result listeye ekliyor.
                results.add(logic);
            }
        }
        return results.toArray(new  Result[results.size()]);
        // hatalı liste bize burada döner
    }
}
