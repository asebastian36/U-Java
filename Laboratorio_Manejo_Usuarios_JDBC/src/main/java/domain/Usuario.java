package domain;

public class Usuario {
    private int idUsuario;
    private String username;
    private String password;

    public Usuario(int idUsuario, String username, String password) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    public String getUsername() {
        return this.username;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "idUsuario=" + idUsuario + ", username=" + username + ", password=" + password;
    }
    
    
}
