const dataToComposition = (heartRate, bloodPressureSystolic, bloodPressureDiastolic) => {
    let data = {}
    let time = new Date().toISOString()
    let composer = "Sidharth Ramesh"
    if (heartRate) {
        const heartRateData = {
            "vital_signs.v0/pulse_heart_beat/rate|unit": "/min",
            "vital_signs.v0/pulse_heart_beat/rate|magnitude": heartRate,
            "vital_signs.v0/pulse_heart_beat/time": time,
            "vital_signs.v0/pulse_heart_beat/language|terminology": "ISO_639-1",
            "vital_signs.v0/pulse_heart_beat/language|code": "en",
            "vital_signs.v0/pulse_heart_beat/encoding|terminology": "IANA_character-sets",
            "vital_signs.v0/pulse_heart_beat/encoding|code": "UTF-8",
        }
        data = {
            ...data,
            ...heartRateData
        }
    }

    if (bloodPressureSystolic) {
        const bloodPressureSystolicData = {
            "vital_signs.v0/blood_pressure/systolic|unit": "mm[Hg]",
            "vital_signs.v0/blood_pressure/systolic|magnitude": bloodPressureSystolic,
        }
        data = {
            ...data,
            ...bloodPressureSystolicData
        }
    }

    if (bloodPressureDiastolic) {
        const bloodPressureDiastolicData = {
            "vital_signs.v0/blood_pressure/diastolic|unit": "mm[Hg]",
            "vital_signs.v0/blood_pressure/diastolic|magnitude": bloodPressureDiastolic,
        }
        data = {
            ...data,
            ...bloodPressureDiastolicData
        }
    }
    if (bloodPressureSystolic || bloodPressureDiastolic) {
        const bloodPressureCommon = {
            "vital_signs.v0/blood_pressure/time": time,
            "vital_signs.v0/blood_pressure/language|code": "en",
            "vital_signs.v0/blood_pressure/language|terminology": "ISO_639-1",
            "vital_signs.v0/blood_pressure/encoding|terminology": "IANA_character-sets",
            "vital_signs.v0/blood_pressure/encoding|code": "UTF-8",
        }
        data = {
            ...data,
            ...bloodPressureCommon
        }
    }
    const context = {
        "vital_signs.v0/category|terminology": "openehr",
        "vital_signs.v0/category|value": "event",
        "vital_signs.v0/category|code": "433",
        "vital_signs.v0/context/start_time": time,
        "vital_signs.v0/context/setting|code": "225",
        "vital_signs.v0/context/setting|value": "home",
        "vital_signs.v0/context/setting|terminology": "openehr",
        "vital_signs.v0/language|code": "en",
        "vital_signs.v0/language|terminology": "ISO_639-1",
        "vital_signs.v0/territory|code": "US",
        "vital_signs.v0/territory|terminology": "ISO_3166-1",
        "vital_signs.v0/composer|name": composer
    }
    return {...data, ...context}
}
