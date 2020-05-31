<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDepEstManEditViewBase from './ormdep-est-man-edit-view-base.vue';

import view_form from '@widgets/orm-dep-est-man/main-form/main-form.vue';

/**
 * 部门编制管理编辑视图
 *
 * @export
 * @class ORMDepEstManEditView
 * @extends {ORMDepEstManEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class ORMDepEstManEditView extends ORMDepEstManEditViewBase { }
</script>