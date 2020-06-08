export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('ehr-portal-view', () => import('@pages/portal/ehr-portal-view/ehr-portal-view.vue'));
    }
};