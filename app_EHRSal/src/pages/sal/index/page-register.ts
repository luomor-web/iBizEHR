export const PageComponents = {
    install(Vue: any, opt: any) {
                Vue.component('sal-item-grid-view', () => import('@pages/sal/sal-item-grid-view/sal-item-grid-view.vue'));
        Vue.component('sal-param-pickup-view', () => import('@pages/sal/sal-param-pickup-view/sal-param-pickup-view.vue'));
        Vue.component('sal-param-pickup-grid-view', () => import('@pages/sal/sal-param-pickup-grid-view/sal-param-pickup-grid-view.vue'));
        Vue.component('sal-scheme-item-edit-view', () => import('@pages/sal/sal-scheme-item-edit-view/sal-scheme-item-edit-view.vue'));
        Vue.component('sal-param-edit-view', () => import('@pages/sal/sal-param-edit-view/sal-param-edit-view.vue'));
        Vue.component('sal-rule-grid-view', () => import('@pages/sal/sal-rule-grid-view/sal-rule-grid-view.vue'));
        Vue.component('sal-rule-detail-grid-view', () => import('@pages/sal/sal-rule-detail-grid-view/sal-rule-detail-grid-view.vue'));
        Vue.component('sal-rule-edit-view', () => import('@pages/sal/sal-rule-edit-view/sal-rule-edit-view.vue'));
        Vue.component('orm-org-pickup-view', () => import('@pages/orm/orm-org-pickup-view/orm-org-pickup-view.vue'));
        Vue.component('sal-rule-pickup-grid-view', () => import('@pages/sal/sal-rule-pickup-grid-view/sal-rule-pickup-grid-view.vue'));
        Vue.component('sal-rule-detail-edit-view', () => import('@pages/sal/sal-rule-detail-edit-view/sal-rule-detail-edit-view.vue'));
        Vue.component('sal-subject-pickup-view', () => import('@pages/sal/sal-subject-pickup-view/sal-subject-pickup-view.vue'));
        Vue.component('sal-scheme-grid-view', () => import('@pages/sal/sal-scheme-grid-view/sal-scheme-grid-view.vue'));
        Vue.component('sal-scheme-item-grid-view', () => import('@pages/sal/sal-scheme-item-grid-view/sal-scheme-item-grid-view.vue'));
        Vue.component('sal-subject-pickup-grid-view', () => import('@pages/sal/sal-subject-pickup-grid-view/sal-subject-pickup-grid-view.vue'));
        Vue.component('orm-org-pickup-grid-view', () => import('@pages/orm/orm-org-pickup-grid-view/orm-org-pickup-grid-view.vue'));
        Vue.component('sal-scheme-edit-view', () => import('@pages/sal/sal-scheme-edit-view/sal-scheme-edit-view.vue'));
        Vue.component('sal-item-edit-view', () => import('@pages/sal/sal-item-edit-view/sal-item-edit-view.vue'));
        Vue.component('sal-source-pickup-view', () => import('@pages/sal/sal-source-pickup-view/sal-source-pickup-view.vue'));
        Vue.component('sal-type-edit-view', () => import('@pages/sal/sal-type-edit-view/sal-type-edit-view.vue'));
        Vue.component('sal-source-pickup-grid-view', () => import('@pages/sal/sal-source-pickup-grid-view/sal-source-pickup-grid-view.vue'));
        Vue.component('sal-param-grid-view', () => import('@pages/sal/sal-param-grid-view/sal-param-grid-view.vue'));
        Vue.component('sal-rule-pickup-view', () => import('@pages/sal/sal-rule-pickup-view/sal-rule-pickup-view.vue'));
        Vue.component('sal-item-pickup-grid-view', () => import('@pages/sal/sal-item-pickup-grid-view/sal-item-pickup-grid-view.vue'));
        Vue.component('sal-item-pickup-view', () => import('@pages/sal/sal-item-pickup-view/sal-item-pickup-view.vue'));
        Vue.component('sal-source-edit-view', () => import('@pages/sal/sal-source-edit-view/sal-source-edit-view.vue'));
        Vue.component('sal-type-grid-view', () => import('@pages/sal/sal-type-grid-view/sal-type-grid-view.vue'));
        Vue.component('sal-source-grid-view', () => import('@pages/sal/sal-source-grid-view/sal-source-grid-view.vue'));
    }
};