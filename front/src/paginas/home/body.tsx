import React from 'react';
import { useNavigate } from 'react-router-dom';
import './Home.css';            

export function Bodydiv() {
    const navigate = useNavigate();

    const handleButtonClick = () => {
        navigate('/CentroDeChamados');
    }

    return (
        <div className='bodyitens'>
            <div className='bodydiv'>
                <div className='div1'>
                    <section className='section1'>
                        <p>
                            VEJA SEUS CHAMADOS SOLICITADOS
                        </p>
                    </section>
                    <div className='divbutton'>
                        <button className='butt' onClick={handleButtonClick}>
                            Clique Aqui
                        </button>
                    </div>
                </div>
                <div className='div2'>
                    <section className='section2'>
                        <p>Lorem ipsum dolor sit amet.</p>
                    </section>
                    
                </div>
            </div>
    </div>
    );
}
