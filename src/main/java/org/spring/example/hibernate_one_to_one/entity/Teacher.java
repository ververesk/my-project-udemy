package org.spring.example.hibernate_one_to_one.entity;

import javax.persistence.*;

    @Entity
    @Table(name="teachers")
    public class Teacher {
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "details_id")
        private Detail empDetail;

        public Teacher(String name) {
            this.name = name;
        }

        public Detail getEmpDetail() {
            return empDetail;
        }

        public void setEmpDetail(Detail empDetail) {
            this.empDetail = empDetail;
        }

        public Teacher() {
        }

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private int id;

        @Column(name = "name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


