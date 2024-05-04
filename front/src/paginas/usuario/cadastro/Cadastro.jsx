import { useEffect, useState } from 'react';
import FormularioCadastroUsuario from './FormularioCadastroUsuario';

const modeloInformacoesFormulario = {
    nome: "",
    senha: "",
    email: "",
    confirmarEmail: "",
    dataNascimento: "",
    nivelPermissao: 1
}

function Cadastro() {
    const [usuarios, setUsuarios] = useState([]);
    const [informacoesFormulario, setInformacoesFormulario] = useState(modeloInformacoesFormulario);

    const eventoAtualizarAoDigitar = (evento) => {
        setInformacoesFormulario({...informacoesFormulario, [evento.target.name]:evento.target.value})
        console.log(informacoesFormulario)
    }

    const eventoCadastrarUsuario = (evento) => {
        // atualizando novamente para evitar erro nas informações enviadas
        eventoAtualizarAoDigitar(evento)

        fetch("http://localhost:8080/usuarios", {
            method: "post",
            body: JSON.stringify(informacoesFormulario),
            headers: {
                'Content-type': 'application/json',
                'Accept': 'application/json'
            }
        })
        .then(retorno_para_json => retorno_para_json.json())
        .then(retorno => console.log(retorno))
    }

    useEffect(() => {
        fetch("http://localhost:8080/usuarios")
        .then(u => u.json())
        .then(usuarios_recebidos => setUsuarios(usuarios_recebidos));

        console.log(usuarios);
    }, []);

    return (
        <div className='d-flex justify-content-center'>
            <FormularioCadastroUsuario evento_atualizar={eventoAtualizarAoDigitar} evento_cadastrar_usuario={eventoCadastrarUsuario} />
        </div>
    );
}

export default Cadastro;