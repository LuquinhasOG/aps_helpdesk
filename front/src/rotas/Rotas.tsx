import { BrowserRouter, Route, Routes } from "react-router-dom";
import Cadastro from "../paginas/centro_de_chamandos/CentroDeChamados";
import Login from "../paginas/usuario/login/Login";
import FormularioCadastroUsuario from "../paginas/usuario/cadastro/FormularioCadastroUsuario";
import Ticket from "../paginas/ticket/Ticket";
import CentroDeChamados from "../paginas/centro_de_chamandos/CentroDeChamados";
import NavBar from "../paginas/home/Navbar";
import Home from "../paginas/home/Home";
import { Bodydiv } from "../paginas/home/body";
import FormularioLoginUsuario from "../paginas/usuario/login/FormularioLoginUsuario";

function Rotas() {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/Ticket" element={<Ticket />} />
                <Route path="/Home" element={<Home />} />
                <Route path="/Login" element={<FormularioLoginUsuario/>} />
                <Route path="/CentroDeChamados" element={<CentroDeChamados />} />
                <Route path="/" element={<FormularioLoginUsuario evento_atualizar={() => {}} evento_logar={() => {}} />} />
                <Route path="/FormularioCadastroUsuario" element={<FormularioCadastroUsuario evento_atualizar={() => {}} evento_cadastrar_usuario={() => {}} />} />
                {/* Adicione outras rotas aqui conforme necessário */}

            </Routes>
        </BrowserRouter>
    );
}

export default Rotas;
