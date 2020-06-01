<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMPOSTEditViewBase from './ormpostedit-view-base.vue';

import view_form from '@widgets/orm-post/gwgl-form/gwgl-form.vue';

/**
 * 岗位设置
 *
 * @export
 * @class ORMPOSTEditView
 * @extends {ORMPOSTEditViewBase}
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
export default class ORMPOSTEditView extends ORMPOSTEditViewBase { }
</script>