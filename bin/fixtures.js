const coachBobId = new ObjectId();

const apptClaireDepaul = {
    _id: new ObjectId(),
    title: "Depaul One-On-One",
    durationMinutes: 60,
    dateTime: new ISODate("2019-02-25T12:00:00Z"),
    notes: "34 Decima Street, SE1 4QQ\n\nThis is a one-on-one with your case-worker to discuss the changes since your last appointment and your next steps.",
    attended: false,
    imageURL: "https://s3.eu-west-2.amazonaws.com/faultfixers-misc/hackathon/depaul-logo.png",
    reasonForNotAttending:  "Claire was too sick",
    appointmentType: "Depaul Coaching",
    appointmentStatus: "NOT_SET",
    appointmentPriority: "MANDATORY"
};
db.appointments.insert(apptClaireDepaul);

const apptClaireCityWest = {
    _id: new ObjectId(),
    title: "CityWest Homes",
    durationMinutes: 30,
    dateTime: new ISODate("2019-02-30T16:30:00Z"),
    notes: "Westminster Council Office, SW1X\n\nThis is to discuss your living situation and to try find you permanent accommodation via the council.",
    attended: false,
    imageURL: "https://s3.eu-west-2.amazonaws.com/faultfixers-misc/hackathon/citywest-logo.jpg",
    reasonForNotAttending: null,
    appointmentType: "City West Homing",
    appointmentStatus: "NOT_SET",
    appointmentPriority: "MANDATORY"
};
db.appointments.insert(apptClaireCityWest);

const apptClaireDoctors = {
    _id: new ObjectId(),
    title: "Doctor's Appointment",
    durationMinutes: 15,
    dateTime: new ISODate("2019-02-15T09:30:00Z"),
    notes: "Appointment scheduled for to ask for a referral to alcohol services.",
    attended: false,
    imageURL: "https://s3.eu-west-2.amazonaws.com/faultfixers-misc/hackathon/nhs-logo.jpg",
    reasonForNotAttending:  'Claire was too sick',
    appointmentType: 'Health',
    appointmentStatus: 'NOT_ATTENDED',
    appointmentPriority: 'SUGGESTED'
};
db.appointments.insert(apptClaireDoctors);

const claireProgressForMotivationAndResponsibility = {
    _id: new ObjectId(),
    type: 'MOTIVATION_AND_RESPONSIBILITY',
    history: [
        {
            date: new ISODate('2019-01-01T11:48:00Z'),
            score: 5,
            comment: 'I am lazy',
        },
        {
            date: new ISODate('2019-01-02T10:00:00Z'),
            score: 2,
            comment: 'I am REALLY lazy',
        },
    ],
};
db.progress.insert(claireProgressForMotivationAndResponsibility);

const claireProgressForDrugAndAlcoholMisuse = {
    _id: new ObjectId(),
    type: 'DRUGS_AND_ALCOHOL',
    history: [
        {
            date: new ISODate('2019-01-01T11:48:00Z'),
            score: 2,
            comment: 'I got drunk every day this week',
        },
        {
            date: new ISODate('2019-01-10T10:00:00Z'),
            score: 7,
            comment: 'I\'m 2 days sober',
        },
    ],
};
db.progress.insert(claireProgressForDrugAndAlcoholMisuse);

const claireProgressForSelfCareAndLivingSkills = {
    _id: new ObjectId(),
    type: 'SELF_CARE_AND_LIVING_SKILLS',
    history: [
        {
            date: new ISODate('2019-01-01T11:48:00Z'),
            score: 8,
            comment: 'Feeling good, cleaned my friend\'s flat and cooked her dinner.',
        },
        {
            date: new ISODate('2019-01-10T10:00:00Z'),
            score: 9,
            comment: 'Still doing well with cleaning and cooking!',
        },
    ],
};
db.progress.insert(claireProgressForSelfCareAndLivingSkills);

const claireProgressForPhysicalHealth = {
    _id: new ObjectId(),
    type: 'PHYSICAL_HEALTH',
    history: [
        {
            date: new ISODate('2019-01-01T11:48:00Z'),
            score: 10,
            comment: 'Healthy at my last check-up. I run regularly.',
        },
    ],
};
db.progress.insert(claireProgressForPhysicalHealth);

const claireProgressForManagingMoney = {
    _id: new ObjectId(),
    type: 'MONEY_MANAGEMENT',
    history: [
        {
            date: new ISODate('2019-01-01T11:48:00Z'),
            score: 3,
            comment: 'Spent £100 on new shoes. That was all the money I had.',
        },
    ],
};
db.progress.insert(claireProgressForManagingMoney);

const claireEvent = {
    _id: new ObjectId(),
    name: "Checkin Event",
    title: "Claire updated her location!",
    bodyText: "Claire has just checked in and updated her current location. Please see if this matches up with her appointments.",
    date: new ISODate()
};
db.events.insert(claireEvent);

const clientClaire = {
    _id: new ObjectId(),
    name: 'Claire',
    phone: '07111222333',
    address: 'Depaul Oldham',
    appointments: [
        new DBRef('appointments', apptClaireDepaul._id),
        new DBRef('appointments', apptClaireCityWest._id),
        new DBRef('appointments', apptClaireDoctors._id),
    ],
    events: [
        new DBRef('events', claireEvent._id),
    ],
    progress: [
        new DBRef('progress', claireProgressForMotivationAndResponsibility._id),
        new DBRef('progress', claireProgressForDrugAndAlcoholMisuse._id),
        new DBRef('progress', claireProgressForSelfCareAndLivingSkills._id),
        new DBRef('progress', claireProgressForPhysicalHealth._id),
        new DBRef('progress', claireProgressForManagingMoney._id),
    ],
    coach: new DBRef('coaches', coachBobId),
    lastCheckedInAt: new ISODate(),
    lastCheckedInLatitude: 53.4851305,
    lastCheckedInLongitude: -2.2401734,
    lastCheckedInDescription: 'Victoria Station, Manchester',
};
db.clients.insert(clientClaire);

const clientDan = {
    _id: new ObjectId(),
    name: 'Dan',
    phone: '07444555666',
    address: 'Depaul East London',
    appointments: [
    ],
    events: [],
    progress: [],
    coach: new DBRef('coaches', coachBobId),
    lastCheckedInAt: new ISODate(),
    lastCheckedInLatitude: 51.5,
    lastCheckedInLongitude: -0.08,
    lastCheckedInDescription: 'Shoreditch High Street, London',
};
db.clients.insert(clientDan);

const coachBob = {
    _id: coachBobId,
    name: 'Bob',
    bio: 'Bob has been working with Depaul since 2012. He studied medicine at UCL and now is a Senior Progression Coach in our Oldham center.',
    jobTitle: 'Senior Progression Coach',
    specialities : "Mental wellbeing",
    photo: '@todo',
    clients: [
        new DBRef('clients', clientClaire._id),
        new DBRef('clients', clientDan._id),
    ]
};
db.coaches.insert(coachBob);

db.users.insert({
    email: 'coach-bob@example.com',
    password: 'pass1234',
    coach: new DBRef('coaches', coachBob._id),
});

db.users.insert({
    email: 'client-claire@example.com',
    password: 'pass1234',
    client: new DBRef('clients', clientClaire._id),
});

db.users.insert({
    email: 'client-dan@example.com',
    password: 'pass1234',
    client: new DBRef('clients', clientDan._id),
});
