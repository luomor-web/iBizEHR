<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMERPORGEditViewBase from './ormerporgedit-view-base.vue';

import view_form from '@widgets/orm-erporg/main-form/main-form.vue';

/**
 * ERP组织中间表编辑视图
 *
 * @export
 * @class ORMERPORGEditView
 * @extends {ORMERPORGEditViewBase}
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
export default class ORMERPORGEditView extends ORMERPORGEditViewBase { }
</script>