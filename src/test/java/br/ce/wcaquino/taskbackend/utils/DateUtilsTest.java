package br.ce.wcaquino.taskbackend.utils;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class DateUtilsTest {

    @Test
    public void deveRetornarTrueParaDatasFuturas() {
        LocalDate data = LocalDate.of(2030, 01,01);
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void deveRetornarFalseParaDatasPassadas() {
        LocalDate data = LocalDate.of(2010, 01,01);
        Assert.assertFalse(DateUtils.isEqualOrFutureDate(data));
    }

    @Test
    public void deveRetornarTrueParaDataAtual() {
        LocalDate data = LocalDate.now();
        Assert.assertTrue(DateUtils.isEqualOrFutureDate(data));
    }

}
