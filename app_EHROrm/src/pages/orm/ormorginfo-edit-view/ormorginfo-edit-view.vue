<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMORGInfoEditViewBase from './ormorginfo-edit-view-base.vue';

import view_form from '@widgets/orm-org-info/main-form/main-form.vue';

/**
 * 组织管理
 *
 * @export
 * @class ORMORGInfoEditView
 * @extends {ORMORGInfoEditViewBase}
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
export default class ORMORGInfoEditView extends ORMORGInfoEditViewBase { }
</script>