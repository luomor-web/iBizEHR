/**
 * Main_3 部件模型
 *
 * @export
 * @class Main_3Model
 */
export default class Main_3Model {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof Main_3Model
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
        prop: 'trmdemdeftionid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'trmdemdeftionname',
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
        name: 'xh',
        prop: 'xh',
        dataType: 'TEXT',
      },
      {
        name: 'trmdepartname',
        prop: 'trmdepartname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'trmdemdeftionname',
        prop: 'trmdemdeftionname',
        dataType: 'TEXT',
      },
      {
        name: 'pxmk',
        prop: 'pxmk',
        dataType: 'SSCODELIST',
      },
      {
        name: 'xqfl',
        prop: 'xqfl',
        dataType: 'SSCODELIST',
      },
      {
        name: 'pxdx',
        prop: 'pxdx',
        dataType: 'TEXT',
      },
      {
        name: 'trmtraincoursename',
        prop: 'trmtraincoursename',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pxzynr',
        prop: 'pxzynr',
        dataType: 'TEXT',
      },
      {
        name: 'pxkssj',
        prop: 'pxkssj',
        dataType: 'DATE',
      },
      {
        name: 'pxjssj',
        prop: 'pxjssj',
        dataType: 'DATE',
      },
      {
        name: 'pxdd',
        prop: 'pxdd',
        dataType: 'TEXT',
      },
      {
        name: 'pxrs',
        prop: 'pxrs',
        dataType: 'INT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'bmjzsj',
        prop: 'bmjzsj',
        dataType: 'DATE',
      },
      {
        name: 'bz',
        prop: 'bz',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'trmdemdeftionid',
        prop: 'trmdemdeftionid',
        dataType: 'GUID',
      },
      {
        name: 'trmtraincourseid',
        prop: 'trmtraincourseid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmdepartid',
        prop: 'trmdepartid',
        dataType: 'PICKUP',
      },
      {
        name: 'trmdemdeftion',
        prop: 'trmdemdeftionid',
        dataType: 'FONTKEY',
      },
    ]
  }

}