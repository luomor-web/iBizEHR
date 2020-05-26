<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMKQDZEditViewBase from './ormbmkqdzedit-view-base.vue';

import view_form from '@widgets/ormbmkqdz/main-form/main-form.vue';

/**
 * 部门考勤地址维护
 *
 * @export
 * @class ORMBMKQDZEditView
 * @extends {ORMBMKQDZEditViewBase}
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
export default class ORMBMKQDZEditView extends ORMBMKQDZEditViewBase { }
</script>