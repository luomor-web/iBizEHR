<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMQYGLEditViewBase from './ormqygledit-view-base.vue';

import view_form from '@widgets/orm-qygl/main-form/main-form.vue';

/**
 * 区域补贴
 *
 * @export
 * @class ORMQYGLEditView
 * @extends {ORMQYGLEditViewBase}
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
export default class ORMQYGLEditView extends ORMQYGLEditViewBase { }
</script>