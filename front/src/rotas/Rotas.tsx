import { BrowserRouter, Route, Routes } from "react-router-dom";
import RotaPrivada from "./RotaPrivada";

// importações das páginas
import Home from "../paginas/home";
import Cadastro from "../paginas/usuario/cadastro";
import Login from "../paginas/usuario/login";
import Ticket from "../paginas/ticket";
import CentroDeChamados from "../paginas/centro_de_chamados";
import NavBar from "../paginas/home/Navbar";

function Rotas() {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/cadastro" element={<Cadastro />}></Route>
                <Route path="/login" element={<Login />}></Route>

                <Route path="/chamado/:id_ticket" element={
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
