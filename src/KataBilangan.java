public class KataBilangan{
    private String[] satuan = {"", "SE", "DUA ", "TIGA ", "EMPAT ", "LIMA ", "ENAM ",
                       "TUJUH ", "DELAPAN ", "SEMBILAN ", "SATU "}; //c
    private String belasan = "BELAS "; //d
    private String puluhan = "PULUH "; //b
    private String ratusan = "RATUS "; //a
    private String ribuan = "RIBU "; //e
    private String terbilang = "" ;

    public KataBilangan(double number){
        double depanKoma;
        double belakangKoma;
        depanKoma = Math.floor(number);
        belakangKoma = number - depanKoma;
        proses((int)depanKoma);
        desimal((float)belakangKoma);
    }

    public void proses(int bilangan){

        while(bilangan != 0){
            if (bilangan / 100_000 > 9){
                terbilang += "out of range!!! ";
                break;
            }
            else if (bilangan / 100_000 > 0){
                display((int)bilangan/100000, 'a');
                bilangan %= 100_000;
                if (bilangan < 1000) display(0, 'e');
            }
            else if (bilangan / 10_000 > 1){
                display((int)bilangan/10_000, 'b');
                bilangan %= 10000;
                if (bilangan < 1000) display(0, 'e');
            }
            else if (bilangan / 10_000 == 1){
                bilangan %= 10000;
                display((int)bilangan / 1000, 'd');
                bilangan %= 1000;
                display(0, 'e');
            }
            else if (bilangan / 1000 > 0 && terbilang == ""){
                display((int)bilangan/1000, 'e');
                bilangan %= 1000;
            }
            else if (bilangan / 1000 == 1){
                display(10, 'e');
                bilangan %= 1000;
            }
            else if (bilangan / 1000 > 1){
                display((int)bilangan/1000, 'e');
                bilangan %= 1000;
            }
            //batas
            else if (bilangan / 100 > 0){
                display((int)bilangan/100, 'a');
                bilangan %= 100;
            }
            else if (bilangan / 10 == 1 && bilangan % 10 != 0){
                display((int)bilangan % 10, 'd');
                bilangan = 0;
            }
            else if (bilangan / 10 >= 1){
                display((int)bilangan/10, 'b');
                bilangan %= 10;
            }
            else if (bilangan / 1 >= 0){
                if (bilangan == 1) display(10, 'c');
                else display((int)bilangan, 'c');
                
                break;
            }
        }
    }
    public void display(int angka, char kategori){
        switch(angka){
            case 10 : terbilang += satuan[10];
                     break;
            case 9 : terbilang += satuan[9];
                     break;
            case 8 : terbilang += satuan[8];
                     break;
            case 7 : terbilang += satuan[7];
                     break;
            case 6 : terbilang += satuan[6];
                     break;
            case 5 : terbilang += satuan[5];
                     break;
            case 4 : terbilang += satuan[4];
                     break;
            case 3 : terbilang += satuan[3];
                     break;
            case 2 : terbilang += satuan[2];
                     break;
            case 1 : terbilang += satuan[1];
                     break;
            case 0 : terbilang += satuan[0];
                     break;
        }
        switch(kategori){
            case 'a' : terbilang += ratusan;
                       break;
            case 'b' : terbilang += puluhan;
                       break;
            case 'd' : terbilang += belasan;
                       break;
            case 'e' : terbilang += ribuan;
                       break;
        }
    }

    public void desimal(float angka){
        if(angka > 0) terbilang += "KOMA ";
        angka *= 100;
        if (angka/10 == 1){
            display(10, 's');
        }
        else
        display((int)angka/10, 's');
        if (angka%10 == 1){
            display(10, 's');
        }
        else display((int)angka%10, 's');
        
    }

    public String getTerbilang() {
        return terbilang;
    }  
    public void ResetTerbilang(){
        terbilang = "";
    }
}