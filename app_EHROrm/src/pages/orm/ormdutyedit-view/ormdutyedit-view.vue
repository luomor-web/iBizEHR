<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMDUTYEditViewBase from './ormdutyedit-view-base.vue';

import view_form from '@widgets/orm-duty/main-form/main-form.vue';

/**
 * 职务设置
 *
 * @export
 * @class ORMDUTYEditView
 * @extends {ORMDUTYEditViewBase}
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
export default class ORMDUTYEditView extends ORMDUTYEditViewBase { }
</script>