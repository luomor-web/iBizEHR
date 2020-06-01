<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMXMBMXEditViewBase from './ormxmbmxedit-view-base.vue';

import view_form from '@widgets/orm-xmbmx/main-form/main-form.vue';

/**
 * 项目部人员明细
 *
 * @export
 * @class ORMXMBMXEditView
 * @extends {ORMXMBMXEditViewBase}
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
export default class ORMXMBMXEditView extends ORMXMBMXEditViewBase { }
</script>