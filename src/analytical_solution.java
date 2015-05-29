public void getSteinerPoint(int nln) {
    int ln = nln + n;
    int nt = adj[nln][0];
    int a  = adj[nln][1];
    int b  = adj[nln][2];
    double a12 = getSquaredLength(nt, a);
    double a23 = getSquaredLength(a, b);
    double a31 = getSquaredLength(b, nt);
    double d12 = Math.sqrt(a12);
    double d23 = Math.sqrt(a23);
    if (a12 + a23 - a31 + d12*d23 <= eps) {
        for (int i = 0; i < d; i++) p[ln][i] = p[a][i];
        length[nln][0] = getLength(ln, nt); length[nln][1] = 0.0; length[nln][2] = getLength(ln, b);
    }
    else {
        double d31 = Math.sqrt(a31);
        if (a12 + a31 - a23 + d12*d31 <= eps) {
            for (int i = 0; i < d; i++) p[ln][i] = p[nt][i];
            length[nln][0] = 0; length[nln][1] = getLength(ln, a); length[nln][2] = getLength(ln, b);
        }
        else {
            if (a23 + a31 - a12 + d23*d31 <= eps) {
                for (int i = 0; i < d; i++) p[ln][i] = p[b][i];
                length[nln][0] = getLength(ln, nt);    length[nln][1] = getLength(ln, a); length[nln][2] = 0.0;
            }
            else {
                double q = (d12 + d23 + d31)/2;
                double s = 2*Math.sqrt(q*(q-d12)*(q-d23)*(q-d31));
                double k0 = (a12 + a31 - a23)*sqrt3over2 + s;
                double k1 = (a23 + a12 - a31)*sqrt3over2 + s;
                double k2 = (a31 + a23 - a12)*sqrt3over2 + s;
                double co = k0*k1*k2/(2*s*(k0+k1+k2));
                for (int i = 0; i < d; i++) p[ln][i] = co*(p[nt][i]/k0 + p[a][i]/k1 + p[b][i]/k2);
                length[nln][0] = getLength(ln, nt);    length[nln][1] = getLength(ln, a); length[nln][2] = getLength(ln, b);
            }
        }
    }
    if (nt >= n) for (int i = 0; i < 3; i++) { if (adj[nt-n][i] == ln) { length[nt-n][i] = length[nln][0]; break; }}
    if (a  >= n) for (int i = 0; i < 3; i++) { if (adj[a -n][i] == ln) { length[a -n][i] = length[nln][1]; break; }}
    if (b  >= n) for (int i = 0; i < 3; i++) { if (adj[b -n][i] == ln) { length[b -n][i] = length[nln][2]; break; }}
    if (test && (d == 2)) drawSteinerTree2d(false);
}
