import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./paginas/home/Home";
import Cadastro from "./paginas/usuario/cadastro/Cadastro";

function RotasAplicativo() {
    return (
        <BrowserRouter>
            <Routes>
                <Route path="/" element={<Home />}></Route>
                <Route path="/usuario/cadastro" element={<Cadastro />}></Route>
            </Routes>
        </BrowserRouter>
    );
}

export default RotasAplicativo