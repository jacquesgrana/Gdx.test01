package com.mycompany.test01.Factory;

import com.mycompany.test01.Entity.Unit.Props.ArtiProps;
import com.mycompany.test01.Interface.ArtiPropsFactoryInterface;

public class ArtiPropsGreenCountryFactory implements ArtiPropsFactoryInterface {

    private final int RANGE_SHORT = 5;
    private final int RANGE_MEDIUM = 10;
    private final int RANGE_LONG = 14;
    private final int RANGE_VERY_LONG = 18;

    private final int ART_ATTACK_LOW = 3;
    private final int ART_ATTACK_MEDIUM = 7;
    private final int ART_ATTACK_HIGH = 9;
    private final int ART_ATTACK_ELITE = 13;

    private final int ART_DEFENSE_LOW = 2;
    private final int ART_DEFENSE_MEDIUM = 4;
    private final int ART_DEFENSE_HIGH = 5;
    private final int ART_DEFENSE_ELITE = 8;

    private final int DELAY_SLOW = 3;
    private final int DELAY_MEDIUM = 2;
    private final int DELAY_FAST = 1;


    @Override
    public ArtiProps getArtiShortRangeLow() {
        return new ArtiProps(
            RANGE_SHORT,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiShortRangeMedium() {
        return new ArtiProps(
            RANGE_SHORT,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiShortRangeHigh() {
        return new ArtiProps(
            RANGE_SHORT,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiShortRangeElite() {
        return new ArtiProps(
            RANGE_SHORT,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiMediumRangeLow() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiMediumRangeMedium() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiMediumRangeHigh() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiMediumRangeElite() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiLongRangeLow() {
        return new ArtiProps(
            RANGE_LONG,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiLongRangeMedium() {
        return new ArtiProps(
            RANGE_LONG,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiLongRangeHigh() {
        return new ArtiProps(
            RANGE_LONG,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiLongRangeElite() {
        return new ArtiProps(
            RANGE_LONG,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getArtiVeryLongRangeLow() {
        return new ArtiProps(
            RANGE_VERY_LONG,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_SLOW
        );
    }

    @Override
    public ArtiProps getArtiVeryLongRangeMedium() {
        return new ArtiProps(
            RANGE_VERY_LONG,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_SLOW
        );
    }

    @Override
    public ArtiProps getArtiVeryLongRangeHigh() {
        return new ArtiProps(
            RANGE_VERY_LONG,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_SLOW
        );
    }

    @Override
    public ArtiProps getArtiVeryLongRangeElite() {
        return new ArtiProps(
            RANGE_VERY_LONG,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_SLOW
        );
    }

    @Override
    public ArtiProps getMortarLow() {
        return new ArtiProps(
            RANGE_SHORT - 1,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMortarMedium() {
        return new ArtiProps(
            RANGE_SHORT - 1,
            ART_ATTACK_MEDIUM - 1,
            ART_DEFENSE_MEDIUM - 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMortarHigh() {
        return new ArtiProps(
            RANGE_SHORT - 1,
            ART_ATTACK_HIGH - 1,
            ART_DEFENSE_HIGH - 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMortarElite() {
        return new ArtiProps(
            RANGE_SHORT - 1,
            ART_ATTACK_ELITE - 1,
            ART_DEFENSE_ELITE - 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getRocketLow() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_LOW + 1,
            ART_DEFENSE_LOW,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getRocketMedium() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_MEDIUM + 1,
            ART_DEFENSE_LOW + 1,
            DELAY_FAST
            );
    }

    @Override
    public ArtiProps getRocketHigh() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_HIGH + 1,
            ART_DEFENSE_MEDIUM + 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getRocketElite() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_ELITE + 1,
            ART_DEFENSE_MEDIUM + 2,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMountainArtiLow() {
        return new ArtiProps(
            RANGE_MEDIUM - 3,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getMountainArtiMedium() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getMountainArtiHigh() {
        return new ArtiProps(
            RANGE_MEDIUM - 1,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getMountainArtiElite() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getParaArtiLow() {
        return new ArtiProps(
            RANGE_MEDIUM - 2,
            ART_ATTACK_LOW,
            ART_DEFENSE_LOW,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getParaArtiMedium() {
        return new ArtiProps(
            RANGE_MEDIUM - 1,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getParaArtiHigh() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getParaArtiElite() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_ELITE,
            ART_DEFENSE_ELITE,
            DELAY_MEDIUM
        );
    }

    @Override
    public ArtiProps getMecaArtiLow() {
        return new ArtiProps(
            RANGE_MEDIUM - 1,
            ART_ATTACK_MEDIUM,
            ART_DEFENSE_MEDIUM + 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMecaArtiMedium() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_HIGH,
            ART_DEFENSE_HIGH + 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMecaArtiHigh() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_HIGH + 1,
            ART_DEFENSE_HIGH + 1,
            DELAY_FAST
        );
    }

    @Override
    public ArtiProps getMecaArtiElite() {
        return new ArtiProps(
            RANGE_MEDIUM,
            ART_ATTACK_ELITE + 1,
            ART_DEFENSE_ELITE + 1,
            DELAY_FAST
        );
    }


}
