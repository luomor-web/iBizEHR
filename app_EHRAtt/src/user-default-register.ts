import { AppLayout, AppMenus, AppUserInfo, AppHeaderMenus, GoBackButton, ModalBreadcrumb, DebugActions } from '@/crm-core';
import DataRevealType from './components/data-reveal-type/data-reveal-type.vue'

/**
 * 注册组件
 */
export const UserDefaultComponent = {
    install(v: any, opt: any) {
        v.component('app-layout', AppLayout);
        v.component('app-menus', AppMenus);
        v.component('app-user-info', AppUserInfo);
        v.component('app-header-menus', AppHeaderMenus);
        v.component('go-back-button', GoBackButton);
        v.component('modal-breadcrumb', ModalBreadcrumb);
        v.component('data-reveal-type', DataRevealType);
        v.component('debug-actions', DebugActions);
    }
};