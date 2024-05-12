import { useState } from "react";
import AberturaChamado from "./AberturaChamado";
import PaginaInicial from "./PaginaInicial";

function CentroDeChamados() {
    const [abrindoChamado, setAbrindoChamado] = useState(false);

    return (
        <div>
            {(abrindoChamado) ? <AberturaChamado /> : <PaginaInicial />}
        </div>
    );
}

export default CentroDeChamados;