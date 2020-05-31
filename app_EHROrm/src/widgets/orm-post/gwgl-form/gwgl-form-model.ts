/**
 * GWGL 部件模型
 *
 * @export
 * @class GWGLModel
 */
export default class GWGLModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof GWGLModel
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
        prop: 'ormpostid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'ormpostname',
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
        dataType: 'INT',
      },
      {
        name: 'ormorgid',
        prop: 'ormorgid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'gwtype',
        prop: 'gwtype',
        dataType: 'SMCODELIST',
      },
      {
        name: 'lgnx',
        prop: 'lgnx',
        dataType: 'INT',
      },
      {
        name: 'isconfidential',
        prop: 'isconfidential',
        dataType: 'SSCODELIST',
      },
      {
        name: 'qzlgnx',
        prop: 'qzlgnx',
        dataType: 'INT',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'GUID',
      },
      {
        name: 'ormpost',
        prop: 'ormpostid',
        dataType: 'FONTKEY',
      },
    ]
  }

}