export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('par-tzgg-grid-view', () => import('@pages/par/par-tzgg-grid-view/par-tzgg-grid-view.vue'));
        Vue.component('par-exam-cycle-edit-view', () => import('@pages/par/par-exam-cycle-edit-view/par-exam-cycle-edit-view.vue'));
        Vue.component('par-tzgg-edit-view', () => import('@pages/par/par-tzgg-edit-view/par-tzgg-edit-view.vue'));
        Vue.component('par-exam-cycle-grid-view', () => import('@pages/par/par-exam-cycle-grid-view/par-exam-cycle-grid-view.vue'));
        Vue.component('par-tzgg-edit-view9', () => import('@pages/par/par-tzgg-edit-view9/par-tzgg-edit-view9.vue'));
        Vue.component('par-tzgg-redirect-view', () => import('@pages/par/par-tzgg-redirect-view/par-tzgg-redirect-view.vue'));
        Vue.component('par-exam-cycle-redirect-view', () => import('@pages/par/par-exam-cycle-redirect-view/par-exam-cycle-redirect-view.vue'));
    }
};