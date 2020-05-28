<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTGWXHWHEditViewBase from './ormpostgwxhwhedit-view-base.vue';

import view_form from '@widgets/ormpost/main-form/main-form.vue';

/**
 * 岗位集设置
 *
 * @export
 * @class ORMPOSTGWXHWHEditView
 * @extends {ORMPOSTGWXHWHEditViewBase}
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
export default class ORMPOSTGWXHWHEditView extends ORMPOSTGWXHWHEditViewBase { }
</script>