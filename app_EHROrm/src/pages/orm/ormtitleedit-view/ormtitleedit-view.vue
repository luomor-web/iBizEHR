<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMTITLEEditViewBase from './ormtitleedit-view-base.vue';

import view_form from '@widgets/orm-title/main-form/main-form.vue';

/**
 * 标准头衔设置
 *
 * @export
 * @class ORMTITLEEditView
 * @extends {ORMTITLEEditViewBase}
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
export default class ORMTITLEEditView extends ORMTITLEEditViewBase { }
</script>