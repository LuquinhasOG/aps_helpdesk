import { BrowserRouter, Route, Routes } from "react-router-dom";
import RotaPrivada from "./RotaPrivada";
import Home from "../paginas/home/Home";
import Cadastro from "../paginas/usuario/cadastro/Cadastro";
import Login from "../paginas/usuario/login/Login";
import Ticket from "../paginas/ticket/Ticket";
import CentroDeChamados from "../paginas/centro_de_chamandos/CentroDeChamados";

function Rotas() {
    // os componentes Route que tiverem RotaPrivada no parâmetro element, são páginas que só irão carregar se o usuário estiver logado
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/cadastro" element={<Cadastro />}></Route>
                <Route path="/login" element={<Login />}></Route>

                <Route path="/chamado" element={
                    <RotaPrivada>
                        <Ticket />
                    </RotaPrivada>}>
                </Route>
                <Route path="/centrodechamados"element={
                    <RotaPrivada>
                        <CentroDeChamados />
                    </RotaPrivada>}>
                </Route>
            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;