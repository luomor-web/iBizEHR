/**
 * BMBZGL 部件模型
 *
 * @export
 * @class BMBZGLModel
 */
export default class BMBZGLModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof BMBZGLModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'ordervalue',
        prop: 'ordervalue',
        dataType: 'INT',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'TEXT',
      },
      {
        name: 'orgcode',
        prop: 'orgcode',
        dataType: 'TEXT',
      },
      {
        name: 'shortname',
        prop: 'shortname',
        dataType: 'TEXT',
      },
      {
        name: 'bmlx',
        prop: 'bmlx',
        dataType: 'SSCODELIST',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'belongregion',
        prop: 'belongregion',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qy',
        prop: 'qy',
        dataType: 'SSCODELIST',
      },
      {
        name: 'gkjz',
        prop: 'gkjz',
        dataType: 'SSCODELIST',
      },
      {
        name: 'bmbzrs',
        prop: 'bmbzrs',
        dataType: 'INT',
      },
      {
        name: 'sjbzrs',
        prop: 'sjbzrs',
        dataType: 'TEXT',
      },
      {
        name: 'startstopsign',
        prop: 'startstopsign',
        dataType: 'SSCODELIST',
      },
      {
        name: 'belongou',
        prop: 'belongou',
        dataType: 'TEXT',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'referjoblevel',
        prop: 'referjoblevel',
        dataType: 'SSCODELIST',
      },
      {
        name: 'orgtype',
        prop: 'orgtype',
        dataType: 'TEXT',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'GUID',
      },
      {
        name: 'ormorgsector',
        prop: 'orgsectorid',
        dataType: 'FONTKEY',
      },
    ]
  }

}