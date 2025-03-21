class UsuarioServico {
    apiLoginUrl: any = "https://api-helpdesk-latest.onrender.com/usuarios";
    nome: String | null = null;
    email: String | null = null;
    senha: String | null = null;
    idUsuario: String | null = null;
    nivelPermissao: String | null = null;

    constructor() {
        this.nome = localStorage.getItem("nome");
        this.email = localStorage.getItem("email");
        this.senha = localStorage.getItem("senha");
        this.idUsuario = localStorage.getItem("id_usuario");
        this.nivelPermissao = localStorage.getItem("nivel_permissao");
    }

    cadastrar(informacoes: object) {
        fetch(this.apiLoginUrl, {
            method: "post",
            body: JSON.stringify(informacoes),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
    } 

    validarLogin() {
        if (this.email == undefined || this.email == "undefined" || this.senha == undefined || this.senha == "undefined") {
            return false;
        }

        return true;
    }

    logar(dados: any, salvar: boolean) {
        try {
            let resposta: object = {};

            fetch(`${this.apiLoginUrl}/login`, {
                method: "post",
                body: JSON.stringify(dados),
                headers: {
                    'Content-type': 'application/json',
                    'Accept': 'application/json'
                }
            })
            .then(retorno_para_json => retorno_para_json.json())
            .then(retorno => {
                resposta = retorno;

                if (salvar) {
                    // implementar serviço de autenticação com token se der tempo
                    localStorage.setItem("id_usuario", retorno.idUsuario);
                    localStorage.setItem("nome", retorno.nome);
                    localStorage.setItem("email", retorno.email);
                    localStorage.setItem("senha", retorno.senha);
                    localStorage.setItem("nivel_permissao", retorno.nivelPermissao);
                }

                location.reload();
            })

            if ("message" in resposta) {
                console.log(resposta.message);
                throw false;
            }
        } catch (e) {
            return e;
        }

        return true;
    }

    logout() {
        localStorage.removeItem("id_usuario");
        localStorage.removeItem("nome");
        localStorage.removeItem("email");
        localStorage.removeItem("senha");
    }
}

export default UsuarioServico;