function BarraLateral({children, referencia}: any) {
    return (
        <aside ref={referencia} className="d-flex flex-column">
            {children}
        </aside>
    );
}

export default BarraLateral;