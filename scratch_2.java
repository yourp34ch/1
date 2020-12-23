class Scratch {
    public static void main(String[] args) {
        int[] ar = {0, -1, 4, 5, -3};
        int count = 0;
        for (int k = 0; k < ar.length; k++) {
            if (ar[k] < 0) {
                for (int n = k; n < ar.length; n++) {
                    if (ar[k] > 0) {
                        count += ar[k];
                    } else {
                        break;
                    }
                }
                break;
            }
        }
    }
}
