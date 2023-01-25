import { Button } from '@mui/material';
import React, { useState } from 'react';

const Krediti = () => {
    const [measurements, setMeasurements] = useState([]);
    const [open, setOpen] = useState(false);
    const [loaded, setLoaded] = useState(false);
    
    
    return (
        <div style={{ padding: '25px' }}>
            <h2>Krediti</h2>
            <p>Seznam vseh odprtih kreditov.</p>
            <Button variant="contained">Dodaj Kredit</Button>
            <br />
            <br />
            
        </div>
    );
}

export default Krediti;