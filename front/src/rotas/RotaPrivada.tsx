import { Route } from "react-router-dom";
import UsuarioServico from "../servicos/UsuarioServico";

const usuarioServico = new UsuarioServico();

// componente para definir quais rotas serão renderizadas para usuário que não estejam logados
function RotaPrivada({children}:any) {
    return usuarioServico.validarLogin() ? children : null;
}

export default RotaPrivada;