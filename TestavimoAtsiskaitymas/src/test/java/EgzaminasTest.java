import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EgzaminasTest {
    private String vartotojoVardasT;
    private String slaptazodisT;
    private String expectedClickSukurtiPositive;
    private String expectedClickSukurtiNegative;


    private String prisijungimoVardasT;
    private String slaptikasT;
    private String expectedClickPrisijungtiPositive;
    private String expectedClickPrisijungtiNegative;

    private String expectedClickAtsijungtiPositive;




    @Before
    public void setupas() {
        Egzaminas.setupas();
//        Egzaminas.clickKurtiPaskyra();
//        vartotojoVardasT = "kede";        //traukinys, gytisg,krioklys,ratas,akmuo,kede
//        slaptazodisT = "kede1";           //traukinys1, gytisgytis, krioklys1, ratas1, akmuo1, kede1
//        Egzaminas.clickSukurti();
//        expectedClickSukurtiPositive = "Galimos operacijos: sudėti, atimti, dauginti, dalinti";
//        expectedClickSukurtiNegative = "Toks vartotojo vardas jau egzistuoja";

        prisijungimoVardasT = "kede";
        slaptikasT = "kede1";
        Egzaminas.clickPrisijungti();
        expectedClickPrisijungtiPositive = "Skaičiuotuvas";
        expectedClickPrisijungtiNegative = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";

        expectedClickAtsijungtiPositive = "Sėkmingai atsijungėte";
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void registracijaPositive() {
        Egzaminas.fillVartotojoVardas(vartotojoVardasT);
        Egzaminas.fillSlaptazodis(slaptazodisT);
        Egzaminas.clickSukurti();
        String actualClickSukurti = Egzaminas.clickSukurtiPositive();
        Assert.assertEquals(expectedClickSukurtiPositive, actualClickSukurti);
    }

    @Test
    public void resgistracijaNegative() {
        Egzaminas.fillVartotojoVardas(vartotojoVardasT);
        Egzaminas.fillSlaptazodis(slaptazodisT);
        Egzaminas.clickSukurti();
        String actualClickSukurti = Egzaminas.clickSukurtiNegative();
        Assert.assertEquals(expectedClickSukurtiNegative, actualClickSukurti);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Test
    public void prisijungtiPositive() {
        Egzaminas.fillPrisijungimoVardas(prisijungimoVardasT);
        Egzaminas.fillSlaptikas(slaptikasT);
        Egzaminas.clickPrisijungti();
        String actualClickPrisijungti = Egzaminas.clickPrisijungtiPositive();
        Assert.assertEquals(expectedClickPrisijungtiPositive, actualClickPrisijungti);
    }

    @Test
    public void prisijungtiNegative() {
        Egzaminas.fillPrisijungimoVardas(prisijungimoVardasT);
        Egzaminas.fillSlaptikas(slaptikasT);
        Egzaminas.clickPrisijungti();
        String actualClickPrisijungti = Egzaminas.clickPrisijungtiNegative();
        Assert.assertEquals(expectedClickPrisijungtiNegative, actualClickPrisijungti);
    }
    @Test
    public void atsijungtiPositive(){
        Egzaminas.fillPrisijungimoVardas(prisijungimoVardasT);
        Egzaminas.fillSlaptikas(slaptikasT);
        Egzaminas.clickPrisijungti();
        Egzaminas.clickAtsijungti();
        String actualClickAtsijungti = Egzaminas.clickAtsijungtiPositive();
        Assert.assertEquals(expectedClickAtsijungtiPositive, actualClickAtsijungti);
    }


}

